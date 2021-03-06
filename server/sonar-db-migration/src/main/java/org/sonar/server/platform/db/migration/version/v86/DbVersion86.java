/*
 * SonarQube
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.platform.db.migration.version.v86;

import org.sonar.server.platform.db.migration.step.MigrationStepRegistry;
import org.sonar.server.platform.db.migration.version.DbVersion;

public class DbVersion86 implements DbVersion {

  @Override
  public void addSteps(MigrationStepRegistry registry) {
    registry
      .add(4100, "Drop QPROFILES_ORG_UUID index from 'quality_profile' table", DropOrganizationUuidIndexFromQualityProfileTable.class)
      .add(4101, "Drop organization_uuid from 'quality_profile' table", DropOrganizationFromQualityProfileTable.class)
      .add(4102, "Drop primary key of table 'default_qprofiles'", DropDefaultQProfilesPk.class)
      .add(4103, "Drop organization_uuid from 'default_qprofiles' table", DropOrganizationFromDefaultQProfiles.class)
      .add(4104, "Add primary key to the table 'default_qprofiles", AddPrimaryKeyToDefaultQProfiles.class)
      .add(4105, "Drop 'organization_uuid' in 'rules_metadata'", DropOrganizationInRulesMetadata.class)
    ;
  }
}
