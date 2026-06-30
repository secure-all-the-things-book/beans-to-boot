package com.example.beans_to_boot.tx1;

import org.springframework.transaction.PlatformTransactionManager;

import java.util.Collection;

class TransactionalDogRepository implements DogRepository {

    private final DogRepository target;
    private final PlatformTransactionManager txm;

    TransactionalDogRepository(PlatformTransactionManager txm,
                               DogRepository target) {
        this.target = target;
        this.txm = txm;
    }

    @Override
    public Collection<Dog> findAll() {
        IO.println("starting transaction");
        var status = this.txm.getTransaction(null);
        try {
            var results = this.target.findAll();
            this.txm.commit(status);
            IO.println("committing transaction");
            return results;
        } //
        catch (Throwable throwable) {
            IO.println("rolling transaction back");
            this.txm.rollback(status);
            throw new RuntimeException(throwable);
        }
    }
}
