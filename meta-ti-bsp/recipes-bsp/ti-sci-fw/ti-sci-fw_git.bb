require recipes-bsp/ti-linux-fw/ti-linux-fw.inc

DEPENDS = "openssl-native u-boot-mkimage-native dtc-native virtual/bootloader"
DEPENDS:remove:am65xx-evm-k3r5 = "virtual/bootloader"
DEPENDS:remove:am65xx-evm-k3r5-sr2 = "virtual/bootloader"
DEPENDS:remove:am65xx-hs-evm-k3r5 = "virtual/bootloader"
DEPENDS:remove:am65xx-hs-evm-k3r5-sr2 = "virtual/bootloader"
DEPENDS:remove:j721e-evm-k3r5 = "virtual/bootloader"
DEPENDS:remove:j721e-hs-evm-k3r5 = "virtual/bootloader"
DEPENDS:remove:j721e-hs-evm-k3r5-sr1-1 = "virtual/bootloader"
DEPENDS:remove:beaglebone-ai64-k3r5 = "virtual/bootloader"

CLEANBROKEN = "1"
PR = "${INC_PR}.2"

# Loaded by R5F core
COMPATIBLE_MACHINE = "k3r5"
COMPATIBLE_MACHINE:aarch64 = "null"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Use TI SECDEV for signing
inherit ti-secdev

SYSFW_SOC ?= "unknown"
SYSFW_SUFFIX ?= "unknown"
SYSFW_CONFIG ?= "unknown"

SYSFW_PREFIX = "sci"
SYSFW_PREFIX:j721e-evm-k3r5 = "fs"
SYSFW_PREFIX:j721e-hs-evm-k3r5 = "fs"
SYSFW_PREFIX:j721e-hs-evm-k3r5-sr1-1 = "fs"
SYSFW_PREFIX:beaglebone-ai64-k3r5 = "fs"
SYSFW_PREFIX:j7200-evm-k3r5 = "fs"
SYSFW_PREFIX:j7200-hs-evm-k3r5 = "fs"
SYSFW_PREFIX:j721s2-evm-k3r5-gp = "fs"
SYSFW_PREFIX:j721s2-evm-k3r5-sr1-hs-fs = "fs"
SYSFW_PREFIX:j721s2-hs-evm-k3r5 = "fs"
SYSFW_PREFIX:j784s4-evm-k3r5-gp = "fs"
SYSFW_PREFIX:j784s4-evm-k3r5-sr1-hs-fs = "fs"
SYSFW_PREFIX:j784s4-hs-evm-k3r5 = "fs"
SYSFW_PREFIX:am62xx-evm-k3r5-gp = "fs"
SYSFW_PREFIX:am62xx-evm-k3r5-hs-se = "fs"
SYSFW_PREFIX:am62xx-evm-k3r5-hs-fs = "fs"
SYSFW_PREFIX:am62xx-lp-evm-k3r5 = "fs"
SYSFW_PREFIX:am62xx-lp-evm-k3r5-hs-se = "fs"
SYSFW_PREFIX:am62xx-lp-evm-k3r5-hs-fs = "fs"
SYSFW_PREFIX:am62axx-evm-k3r5-gp = "fs"
SYSFW_PREFIX:am62axx-evm-k3r5-hs-fs = "fs"
SYSFW_PREFIX:am62axx-evm-k3r5-hs-se = "fs"

SYSFW_TISCI = "${S}/ti-sysfw/ti-${SYSFW_PREFIX}-firmware-${SYSFW_SOC}-*.bin"

SYSFW_TIBOOT3 = "tiboot3-${SYSFW_SOC}-${SYSFW_SUFFIX}-${SYSFW_CONFIG}.bin"
SYSFW_TIBOOT3_SYMLINK ?= "tiboot3.bin"

SYSFW_BINARY = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_SUFFIX}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE = "sysfw-${SYSFW_SOC}-${SYSFW_SUFFIX}-${SYSFW_CONFIG}.itb"
SYSFW_SYMLINK ?= "sysfw.itb"

SYSFW_VBINARY:am65xx-evm-k3r5 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:am65xx-evm-k3r5-sr2 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:am65xx-hs-evm-k3r5 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:am65xx-hs-evm-k3r5-sr2 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:j721e-evm-k3r5 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:j721e-hs-evm-k3r5 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_VBINARY:j721e-hs-evm-k3r5-sr1-1 = "sysfw-${PV}-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"

SYSFW_IMAGE:am65xx-evm-k3r5 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:am65xx-evm-k3r5-sr2 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:am65xx-hs-evm-k3r5 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:am65xx-hs-evm-k3r5-sr2 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:j721e-evm-k3r5 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:j721e-hs-evm-k3r5 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"
SYSFW_IMAGE:j721e-hs-evm-k3r5-sr1-1 = "sysfw-${SYSFW_SOC}-${SYSFW_CONFIG}.itb"

CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_configure[noexec] = "1"

EXTRA_OEMAKE = "\
    CROSS_COMPILE=${TARGET_PREFIX} SOC=${SYSFW_SOC} SOC_TYPE=${SYSFW_SUFFIX} \
    CONFIG=${SYSFW_CONFIG} SYSFW_DIR="${S}/ti-sysfw" \
    SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin" \
"
EXTRA_OEMAKE:remove:am65xx-evm-k3r5 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:am65xx-evm-k3r5-sr2 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:am65xx-hs-evm-k3r5 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:am65xx-hs-evm-k3r5-sr2 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:j721e-evm-k3r5 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:j721e-hs-evm-k3r5 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:j721e-hs-evm-k3r5-sr1-1 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""
EXTRA_OEMAKE:remove:beaglebone-ai64-k3r5 = "SBL="${STAGING_DIR_HOST}/boot/u-boot-spl.bin""

do_compile() {
	cd ${WORKDIR}/imggen/
	oe_runmake
}

do_install() {
	install -d ${D}/boot

	if [ -f "${WORKDIR}/imggen/${SYSFW_BINARY}" ]; then
		install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${D}/boot/${SYSFW_VBINARY}
		ln -sf ${SYSFW_VBINARY} ${D}/boot/${SYSFW_IMAGE}
		if [ ! -z "${SYSFW_SYMLINK}" ]; then
			ln -sf ${SYSFW_VBINARY} ${D}/boot/${SYSFW_SYMLINK}
		fi
	fi

	if [ -f "${WORKDIR}/imggen/${SYSFW_TIBOOT3}" ]; then
		install -m 644 ${WORKDIR}/imggen/${SYSFW_TIBOOT3} ${D}/boot/${SYSFW_TIBOOT3}
		if [ ! -z "${SYSFW_TIBOOT3_SYMLINK}" ]; then
			ln -sf ${SYSFW_TIBOOT3} ${D}/boot/${SYSFW_TIBOOT3_SYMLINK}
		fi
	fi
}

FILES:${PN} = "/boot"

inherit deploy

do_deploy () {
	install -d ${DEPLOYDIR}

	if [ -f "${WORKDIR}/imggen/${SYSFW_BINARY}" ]; then
		install -m 644 ${WORKDIR}/imggen/${SYSFW_BINARY} ${DEPLOYDIR}/${SYSFW_VBINARY}
		ln -sf ${SYSFW_VBINARY} ${DEPLOYDIR}/${SYSFW_IMAGE}
		if [ ! -z "${SYSFW_SYMLINK}" ]; then
			ln -sf ${SYSFW_VBINARY} ${DEPLOYDIR}/${SYSFW_SYMLINK}
			install -m 644 ${SYSFW_TISCI} ${DEPLOYDIR}/
		fi
	fi

	if [ -f "${WORKDIR}/imggen/${SYSFW_TIBOOT3}" ]; then
		install -m 644 ${WORKDIR}/imggen/${SYSFW_TIBOOT3} ${DEPLOYDIR}/${SYSFW_TIBOOT3}
		if [ ! -z "${SYSFW_TIBOOT3_SYMLINK}" ]; then
			ln -sf ${SYSFW_TIBOOT3} ${DEPLOYDIR}/${SYSFW_TIBOOT3_SYMLINK}
			install -m 644 ${SYSFW_TISCI} ${DEPLOYDIR}/
		fi
	fi
}

addtask deploy before do_build after do_compile
