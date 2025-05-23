#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp smartlibrary.product.commcon --module-path smartlibrary.product.commcon -m smartlibrary.product.commcon 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE smartlibrary_product_commcon' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_commcon') \gexec" | psql "postgresql://postgres:asterisk2@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:asterisk2@localhost/smartlibrary_product_commcon"
done

wait