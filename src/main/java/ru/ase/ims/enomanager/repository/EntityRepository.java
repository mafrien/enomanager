package ru.ase.ims.enomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ase.ims.enomanager.model.EnoviaEntity;

import java.util.List;
import java.util.Optional;

public interface EntityRepository extends JpaRepository<EnoviaEntity, Long> {
    Optional<EnoviaEntity> findByEntityNameAndReleaseId(String entityName, Long releaseId);
    List<EnoviaEntity> findAllByReleaseId(Long releaseId);
    List<EnoviaEntity> findAllByReleaseIdAndType(Long releaseId, String type);

    @Query("FROM EnoviaEntity e WHERE e.release.id = :releaseId and e.type = :type and e.entityName like %:searchWord%")
    List<EnoviaEntity> findAllByReleaseIdAndTypeAndSearchWord(@Param("releaseId") Long releaseId,
                                                              @Param("type") String type,
                                                              @Param("searchWord") String searchWord);
}
