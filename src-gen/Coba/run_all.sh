#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE smartlibrary_product_coba' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_coba') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/smartlibrary_product_coba"
done

java -cp smartlibrary.product.coba --module-path smartlibrary.product.coba -m smartlibrary.product.coba &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait