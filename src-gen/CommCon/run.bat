echo SELECT 'CREATE DATABASE smartlibrary_product_commcon' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_commcon') \gexec | psql "postgresql://postgres:asterisk2@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:asterisk2@localhost/smartlibrary_product_commcon"

java -cp smartlibrary.product.commcon --module-path smartlibrary.product.commcon -m smartlibrary.product.commcon