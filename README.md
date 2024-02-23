# Notes
This is not a project that belongs to the parent project. This is the original project: https://github.com/limboemu
# What's new
- More modern interface.
- Added Boot menu, Intel IOMMU, Virtio Memory, Virtio GPU, Virtio Serial, Virtio Random Number Generator, JIT Cache (1MB), Dual channel memory, UEFI.

Notes
- The virtual machine status notification feature is not yet supported on Android 12+.
- It may not work on Android 13+ OS on some devices.
- If the UEFI file cannot be loaded. Create a folder named "limbo" in internal storage. Go back to Limbo app, select Hard Disk A, select New, select CHANGE DIRECTORY and select the folder named "limbo" just created earlier. And now deselect and re-select UEFI.