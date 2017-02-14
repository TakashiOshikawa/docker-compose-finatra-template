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


# docker-compose

- docker-compose build
  プロジェクト全体をビルドする

- docker-compose up
  プロジェクトをフォアグラウンドで実行する
  ログなどが出力される

- docker-compose up -d
  デタッチドモード

- docker-compose down
  プロジェクトを終了させる コンテナは消えない

- docker-compose run buildcache ls /root
指定コンテナの中でコマンドを実行することが出来る

- docker-compose run finatra-server sbt 'run -http.port=:9000 -http.name=:0.0.0.0'
finatra-serverを起動する
