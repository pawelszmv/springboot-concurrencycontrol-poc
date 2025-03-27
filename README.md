# Concurency control POC in Java Spring Boot 

The goal of this POC is to compare differnet concurency control techniques available in Spring Boot

## Startup 

- Use `docker compose up` to start the Postgres database container 
- Start the `ConcurrencyControlApplication` locally 
- Run `EndPointTest`


## Tested techniques 
![Pessimistic vs Optimistic strategy](readmeImages/image.png)

### No strategy
Baseline `@UniqueConstraint(columnNames = "name")`


### Optimistic Strategy 

JPA: Use the `@Version` annotation on an entity to mark it as versioned.

VersionProduct will apply (Database Level → Optimistic Lock) using @Version

#### How It Works:
When an entity like `VersionProduct` is updated:
1. Read Phase: The entity is loaded from the database, including the version field.
1. Update Phase: Before updating, JPA compares the current version in the database with the version in the entity.
- If they match, the update is applied, and the version is incremented.

- If they don't match, an `OptimisticLockException` is thrown, signaling a concurrent modification.

#### Use case 
- Preventing Lost Updates

#### Advantages and Disadvantages of Optimistic Locking (`@Version`)  

| **Advantages**                              | **Disadvantages**                             |
|----------------------------------------------|-----------------------------------------------|
| Avoids row locks | **Conflict Handling Required**: Must handle `OptimisticLockException` (e.g., retries). |
| Database Independence, Works with any JPA-supported database.  | Frequent conflicts can degrade performance. |


### Test
Run `VersionEndPointTest` 
It simulates multiple user buying the same item, each time the amount will be decreased, when the amount < 1, it should return `"Not enough quantity"` message. 
There is no retry mechanism implemented, thus it will often fail.


### Pesimistic Strategy 
JPA: `@Transactional` how about this????

#### Memory Level
SyncProduct, I will apply (Memory Level → Pessimistic Lock) using synchronized

##### Synchronized blocks or methods will not work properly in a distributed microservices environment with multiple replicas.

#### Database Level
LockProduct, I will apply (Database Level → Pessimistic Lock) using @Lock(LockModeType.PESSIMISTIC_WRITE)
