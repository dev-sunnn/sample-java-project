-- DB切り替え
\c sample_postgres_db;

-- テーブルを削除
DROP TABLE IF EXISTS "sample";

-- sample テーブル作成
CREATE TABLE "sample" (
    "id" serial PRIMARY KEY,
    "name" VARCHAR( 100 ),
    "path" VARCHAR( 2000 ),
    "update_date" TIMESTAMP,
    "create_date" TIMESTAMP,
    "delete_date" TIMESTAMP
);

