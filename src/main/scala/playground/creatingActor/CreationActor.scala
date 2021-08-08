package playground.creatingActor

import akka.actor.{Actor, ActorSystem, Props}

object CreationActor extends App {

  val actorSystem = ActorSystem("TestSystem")

  println(actorSystem.name)

  class FirstActor extends Actor {

    // internal data
    var count = 0

    // behavior
    def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        count += message.length
        println(message)
        println(count)
    }
  }

  val firstActor = actorSystem.actorOf(Props[FirstActor], "firstActorName")

  println(firstActor.path)
  firstActor ! "hi this is message"
  firstActor ! "hi this is message"
}
