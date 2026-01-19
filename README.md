# My Android Calculator

这是一个最小的 Android Jetpack Compose 示例应用（简单计算器）。本仓库配置了 GitHub Actions，可在 push 到 main 或手动触发时自动构建 debug APK 并创建 Release。

手机端快速指南：
1. 在仓库页面 Actions，等待或手动触发 workflow（"Build and Release APK"）。  
2. 构建成功后，进入仓库 Releases（或 Actions 的日志底部会有 Release 链接），下载 APK（文件名：app-debug.apk）。  
3. 在手机上允许“安装未知来源”，然后打开下载的 APK 安装即可。