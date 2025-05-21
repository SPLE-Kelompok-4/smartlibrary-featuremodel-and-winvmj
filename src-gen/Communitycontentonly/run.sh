#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp smartlibrary.product.communitycontentonly --module-path smartlibrary.product.communitycontentonly -m smartlibrary.product.communitycontentonly 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE smartlibrary_product_communitycontentonly' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_communitycontentonly') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/smartlibrary_product_communitycontentonly"
done

wait