#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE smartlibrary_product_elitra' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_elitra') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/smartlibrary_product_elitra"
done

java -cp smartlibrary.product.elitra --module-path smartlibrary.product.elitra -m smartlibrary.product.elitra &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait