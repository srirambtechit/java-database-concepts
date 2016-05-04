# H2 Database

## Introduction

- In memory database
- DB not created until client open a connection

## Different mode

- WebServer (access via browser)
- TCP Server (Client/Server Arch)
- PG Server (PostgreSQL client)

## Server starting

- start Server from command line with default values
`java -cp h2*.jar org.h2.tools.Server`

- To know default values
`java -cp h2*.jar org.h2.tools.Server -?`

## SQL Mode

- start H2 in console
`java -cp h2*.jar org.h2.tools.Shell`

