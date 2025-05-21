echo SELECT 'CREATE DATABASE smartlibrary_product_coba' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_coba') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/smartlibrary_product_coba"

java -cp smartlibrary.product.coba --module-path smartlibrary.product.coba -m smartlibrary.product.coba