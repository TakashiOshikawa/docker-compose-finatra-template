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


# finatra-serverのrun参考コマンド プロジェクトルートと.ivyキャッシュと.sbtキャッシュをマウント
docker run --rm -it -p 9000:9000 -v $(pwd)/buildcache/.ivy2/cache:/root/.ivy2/cache -v $(pwd)/buildcache/.sbt/boot:/root/.sbt/boot -v $(pwd):/var/app --name finatra-server takashioshikawa/scala-2.11.7
