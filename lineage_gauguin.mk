#
# SPDX-FileCopyrightText: The LineageOS Project
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
TARGET_SUPPORTS_OMX_SERVICE := false
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit from gauguin device
$(call inherit-product, device/xiaomi/gauguin/device.mk)

# Inherit some common PixelOS stuff.
$(call inherit-product, vendor/lineage/config/common_full_phone.mk)

# Device identifier. This must come after all inclusions.
PRODUCT_NAME := lineage_gauguin
PRODUCT_DEVICE := gauguin
PRODUCT_BRAND := Xiaomi
PRODUCT_MANUFACTURER := Xiaomi

PRODUCT_GMS_CLIENTID_BASE := android-xiaomi

PRODUCT_BUILD_PROP_OVERRIDES += \
    BuildDesc="gauguin-user 12 RKQ1.200826.002 V14.0.2.0.SJSMIXM release-keys" \
    BuildFingerprint=Xiaomi/gauguin_global/gauguin:12/RKQ1.200826.002/V14.0.2.0.SJSMIXM:user/release-keys

# AxionOS device props
AXION_MAINTAINER := Shailesh
AXION_PROCESSOR := Snapdragon_750G
AXION_CAMERA_REAR_INFO := 108,8,2,2
AXION_CAMERA_FRONT_INFO := 16
TARGET_ENABLE_BLUR := true
TARGET_IS_LOW_RAM := false
TARGET_NEEDS_DOZE_FIX := false

TARGET_INCLUDE_AXFX := true

# safely disable libperfmgr without breaking boot (set to true)
TARGET_DISABLES_LIBPERF ?= false

# CPU governor support
PERF_GOV_SUPPORTED := true
PERF_DEFAULT_GOV := schedutil
PERF_ANIM_OVERRIDE := true

TARGET_SUPPORTED_REFRESH_RATES := 60,90,120

TORCH_STR_SUPPORTED := true

BYPASS_CHARGE_SUPPORTED := true

TARGET_TOUCH_BOOST_SUPPORTED := true
