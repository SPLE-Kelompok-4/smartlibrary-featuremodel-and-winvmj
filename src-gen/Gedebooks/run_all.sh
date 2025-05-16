#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE smartlibrary_product_gedebooks' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_gedebooks') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/smartlibrary_product_gedebooks"
done

java -cp smartlibrary.product.gedebooks --module-path smartlibrary.product.gedebooks -m smartlibrary.product.gedebooks &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait