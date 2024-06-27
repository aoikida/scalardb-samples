# 分散 SNS

## 概要

- ユーザーがアカウントを作成する
- ユーザーがログインできる
- ユーザー一覧を取得できる
- ユーザーが現時点で所属しているサーバーを切り替えできる
- ユーザーが現時点で所属しているサーバーに投稿を作成できる
- ユーザーが現時点で所属しているサーバーに投稿されたポストを一覧で閲覧できる

## データベース設計

- MySQL と Cassandra を使う

### User

- MySQL と Cassandra で同じ情報を書き込む

#### User スキーマ

- id
- username
- password

### Post

- 今いるサーバーに対応したデータベースに書き込む

#### Post スキーマ

- id
- user_id
- content

## API

### Create User

- parameter

  - username
  - password

- error handling
  - username が既に存在している

### Login User

- parameter

  - username
  - password

- error handling
  - username が存在しない
  - password が不正

### Read All User

- parameter
  - なし

### Create Post

- parameter
  - server_id
  - user_id
  - message

### Rea All Post

- parameter
  - server_id
