/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cprassoc.solr.auth.security;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableMap;
import static java.util.Collections.unmodifiableSet;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * A requestHandler should implement this interface to provide the well known permission
 * at request time
 */
public interface PermissionNameProvider {
  enum Name {
    COLL_EDIT_PERM("collection-admin-edit", null),
    COLL_READ_PERM("collection-admin-read", null),
    CORE_READ_PERM("core-admin-read", null),
    CORE_EDIT_PERM("core-admin-edit", null),
    READ_PERM("read", "*"),
    UPDATE_PERM("update", "*"),
    CONFIG_EDIT_PERM("config-edit", "*"),
    CONFIG_READ_PERM("config-read", "*"),
    SCHEMA_READ_PERM("schema-read", "*"),
    SCHEMA_EDIT_PERM("schema-edit", "*"),
    SECURITY_EDIT_PERM("security-edit", null),
    SECURITY_READ_PERM("security-read", null),
    METRICS_READ_PERM("metrics-read", null),
    ALL("all", unmodifiableSet(new HashSet<>(asList("*", null))))
    ;
    final String name;
    final Set<String> collName;

    Name(String s, Object collName) {
      name = s;
      this.collName = collName instanceof Set? (Set<String>)collName : singleton((String)collName);
    }

    public static Name get(String s) {
      return values.get(s);
    }

    public String getPermissionName() {
      return name;
    }
  }

  Set<String> NULL = singleton(null);
  Set<String> ANY = singleton("*");

  Map<String, Name> values = unmodifiableMap(asList(Name.values()).stream().collect(toMap(Name::getPermissionName, identity())));

  
}