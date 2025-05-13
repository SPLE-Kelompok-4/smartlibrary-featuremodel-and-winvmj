echo SELECT 'CREATE DATABASE smartlibrary_product_gedebooks' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_gedebooks') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/smartlibrary_product_gedebooks"

java -cp smartlibrary.product.gedebooks --module-path smartlibrary.product.gedebooks -m smartlibrary.product.gedebooks