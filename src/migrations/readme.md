# CommandLine

```bash
$ mvn db-migrator:new -Dname=create_db
$ mvn db-migrator:migrate
$ mvn process-classes
$ mvn activejdbc-instrumentation:instrument
$ mvn process-classes;mvn activejdbc-instrumentation:instrument
```