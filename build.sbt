name := "akka-playground"

organization := "home"

version := "0.1"

scalaVersion := "2.12.14"

lazy val akkaVersion    = "2.5.13"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest"     %% "scalatest"    % "3.0.5"
)
