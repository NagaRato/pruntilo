package nl.kaiherwijn.pruntilo.controller;

import nl.kaiherwijn.pruntilo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
