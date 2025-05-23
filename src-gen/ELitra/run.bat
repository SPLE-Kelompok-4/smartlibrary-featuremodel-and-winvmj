echo SELECT 'CREATE DATABASE smartlibrary_product_elitra' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_elitra') \gexec | psql "postgresql://postgres:asterisk2@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:asterisk2@localhost/smartlibrary_product_elitra"

java -cp smartlibrary.product.elitra --module-path smartlibrary.product.elitra -m smartlibrary.product.elitra