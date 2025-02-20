package dev.keyairen.ufcdashboard.Repository;

import dev.keyairen.ufcdashboard.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, String> {

    Fighter findByFighterName(String fighterName);
}
