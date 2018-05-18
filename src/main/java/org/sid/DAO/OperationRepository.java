package org.sid.DAO;

import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT o FROM Operation o WHERE o.compte.code =:X order by o.dateOperation desc ")
    public Page<Operation> listOperation(@Param("X") String codecpte, Pageable pageable);
}
