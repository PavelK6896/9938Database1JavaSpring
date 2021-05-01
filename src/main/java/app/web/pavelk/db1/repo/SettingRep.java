package app.web.pavelk.db1.repo;

import app.web.pavelk.db1.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRep extends JpaRepository<Setting, Long> {
}
