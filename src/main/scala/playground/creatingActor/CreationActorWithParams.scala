package playground.creatingActor

import akka.actor.{Actor, ActorSystem, Props}

object CreationActorWithParams extends App {

  val actorSystem = ActorSystem("TestSystem")

  println(actorSystem.name)

  class FirstActor(name:String) extends Actor {

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

  val firstActor = actorSystem.actorOf(Props(new FirstActor("name")), "firstActorName")

  println(firstActor.path)
  firstActor ! "hi this is message"
  firstActor ! "hi this is message"
}
