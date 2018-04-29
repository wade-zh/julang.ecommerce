F:
CD F:\repository\julang\julang.ecommerce\trunk\
CD store-entity
mvn assembly:single
CD ../store-common
mvn assembly:assembly
CD ../store-api-gateway
mvn assembly:assembly