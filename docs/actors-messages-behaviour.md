
###system
to create an actor we need actor system

```scala
import akka.actor.ActorSystem
val actorSystem = ActorSystem("testSystem")
```

###actors

* actors are uniquely identified
* messages are asynchronous
* each actor may respond differently
* actors are encupsulated

###what we need to create an actor

* class that extends from Actor class
* method receive that is PartialFunction (behavior)
* so actor is consist of internal data and behavior

```scala
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
```

###inisialization an actor

* actorSystem.actorOf - Creates new actor as child of this context
* we can only define actor ref via actor system to communicate with an actor
```scala
val firstActor: ActorRef = actorSystem.actorOf(Props[FirstActor])
```
* we can not define actor via new 

```scala
new FirstActor()

Exception in thread "main" akka.actor.ActorInitializationException: You cannot create an instance of [playground.Playground$FirstActor] explicitly using the constructor (new). You have to use one of the 'actorOf' factory methods to create a new actor. See the documentation.

```

* when we create reference of the same actor without setting a name 
  actor system gives them unique names 
```scala
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

val firstActor: ActorRef = actorSystem.actorOf(Props[FirstActor])
val firstActor2: ActorRef = actorSystem.actorOf(Props[FirstActor])
println(firstActor.path)
println(firstActor2.path)
firstActor ! "this is test message"
firstActor2 ! "this is test message"

}
```
as you can see from log we define two reference
and two different actor were created
and result :
```
TestSystem
akka://TestSystem/user/$a
akka://TestSystem/user/$b
this is test message
this is test message
20
20

```
* we can not create two actors with the same name
```scala
  val firstActor: ActorRef = actorSystem.actorOf(Props[FirstActor], "actor")
  val firstActor2: ActorRef = actorSystem.actorOf(Props[FirstActor], "actor")
```

```
Exception in thread "main" akka.actor.InvalidActorNameException: actor name [actor] is not unique!
```