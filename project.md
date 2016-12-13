# docker-compose.yml
container
- finatra-server
- mysql
- buildcache

# sbt
- finatra
- sbt-resolver
- sbt-assembly
- ScalaTest

# migration tool
- flyway

