package models

import sorm._

object DB extends Instance(
  entities = Seq(Entity[Cat]()),
  url = "jdbc:mysql://localhost:3306/cat?useUnicode=true&characterEncoding=UTF-8",
  user = "root"
)