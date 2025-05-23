#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp smartlibrary.product.elitra --module-path smartlibrary.product.elitra -m smartlibrary.product.elitra 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE smartlibrary_product_elitra' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_elitra') \gexec" | psql "postgresql://postgres:asterisk2@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:asterisk2@localhost/smartlibrary_product_elitra"
done

wait