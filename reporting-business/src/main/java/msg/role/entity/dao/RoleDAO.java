// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.role.entity.dao;

import msg.permission.PermissionEntity;
import msg.role.entity.RoleEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * The DAO for the RoleEntity Entities.
 *
 * @author msg-system ag;  Daniel Donea
 * @since 1.0
 */
@Stateless
public class RoleDAO {

    @PersistenceContext(unitName = "persistenceUnit", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
    public List<RoleEntity>  getRolesByTypeList(final List<String> typeList) {
        return em.createNamedQuery(RoleEntity.QUERY_GET_ROLES_BY_TYPE_LIST, RoleEntity.class)
                .setParameter(RoleEntity.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }

    public RoleEntity getRoleById(final long id) {
        return em.createNamedQuery(RoleEntity.QUERY_GET_ROLE_BY_ID, RoleEntity.class)
                .setParameter(RoleEntity.INPUT_ID, id)
                .getSingleResult();
    }

    public List<RoleEntity> getAllRolesAndPermissions() {
        List<RoleEntity> roleEntities = em.createNamedQuery(RoleEntity.GET_PERMISSIONSANDROLES, RoleEntity.class)
                .getResultList();
        return roleEntities;
    }

    public RoleEntity addPermission(RoleEntity roleEntity, PermissionEntity permissionEntity) {
        roleEntity.getPermissions().add(permissionEntity);
        return em.merge(roleEntity);
    }

    public List<String> getAllRolesByType() {
        return em.createNamedQuery(RoleEntity.GET_ALL_ROLES_TYPE, String.class)
                .getResultList();
    }


}
