echo SELECT 'CREATE DATABASE smartlibrary_product_communitycontentonly' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'smartlibrary_product_communitycontentonly') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/smartlibrary_product_communitycontentonly"

java -cp smartlibrary.product.communitycontentonly --module-path smartlibrary.product.communitycontentonly -m smartlibrary.product.communitycontentonly