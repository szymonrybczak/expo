/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

#pragma once

#include <gmock/gmock.h>

#include <ABI45_0_0React/ABI45_0_0renderer/scheduler/SurfaceHandler.h>

namespace ABI45_0_0facebook {
namespace ABI45_0_0React {

class MockSurfaceHandler : public SurfaceHandler {
 public:
  MockSurfaceHandler() : SurfaceHandler("moduleName", 0){};

  MOCK_QUALIFIED_METHOD1(setDisplayMode, const noexcept, void(DisplayMode));
  MOCK_QUALIFIED_METHOD0(getSurfaceId, const noexcept, SurfaceId());
};

} // namespace ABI45_0_0React
} // namespace ABI45_0_0facebook
