// Copyright 2026 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.remote.common;

import com.google.devtools.build.lib.actions.ActionContext;
import com.google.devtools.build.lib.actions.ArtifactExpander;
import com.google.devtools.build.lib.actions.ArtifactPathResolver;
import com.google.devtools.build.lib.actions.ExecException;
import com.google.devtools.build.lib.actions.ForbiddenActionInputException;
import com.google.devtools.build.lib.actions.InputMetadataProvider;
import com.google.devtools.build.lib.actions.Spawn;
import com.google.devtools.build.lib.remote.common.RemoteCacheClient.ActionKey;
import com.google.protobuf.ByteString;
import java.io.IOException;

/** Action context for computing an exact remote action key without executing or uploading. */
public interface ProducerActionKeyContext extends ActionContext {
  ActionKey computeActionKey(
      Spawn spawn,
      InputMetadataProvider inputMetadataProvider,
      ArtifactExpander artifactExpander,
      ArtifactPathResolver artifactPathResolver)
      throws IOException, ExecException, ForbiddenActionInputException, InterruptedException;

  ActionKey computeSyntheticTestActionKey(ByteString logicalIdentity, ActionKey producerActionKey);
}
