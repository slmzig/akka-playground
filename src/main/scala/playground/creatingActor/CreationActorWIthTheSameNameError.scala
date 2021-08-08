package playground.creatingActor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object CreationActorWIthTheSameNameError extends App {

  val actorSystem = ActorSystem("TestSystem")

  println(actorSystem.name)

  class FirstActor extends Actor {

    // internal data
    var count = 0

    // behavior
    def receive: PartialFunction[Any, Unit] = {
      case message:String =>
        count += message.length
        println(message)
        println(count)
    }
  }

  val firstActor: ActorRef = actorSystem.actorOf(Props[FirstActor], "actor")
  // this will throw error
  val firstActor2: ActorRef = actorSystem.actorOf(Props[FirstActor], "actor")

}
