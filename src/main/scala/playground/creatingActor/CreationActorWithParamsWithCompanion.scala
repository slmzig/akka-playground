package playground.creatingActor

import akka.actor.{Actor, ActorSystem, Props}

object CreationActorWithParamsWithCompanion extends App {

  val actorSystem = ActorSystem("TestSystem")

  println(actorSystem.name)

  class FirstActor(param1: String, param2: String) extends Actor {

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

  object FirstActor {
    def props(param1: String, param2: String): Props = Props(new FirstActor(param1, param2))
  }

  val firstActor = actorSystem.actorOf(FirstActor.props("param1", "param2"), "firstActorName")

  println(firstActor.path)
  firstActor ! "hi this is message"
  firstActor ! "hi this is message"
}
