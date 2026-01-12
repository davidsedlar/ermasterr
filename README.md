# ERMaster

A fork of ERMaster. Faster, Better, VCS-friendly.

Original version is http://ermaster.sourceforge.net  

* ERMaster is GUI editor for ER diagram.  
* It runs as Eclipse plug-in.  
* It can be done graphically to making ER diagram, printing ER diagram, exporting the DDL from ER diagram, etc. .  
* Moreover, importing from DB, management of the group, and the historical management, etc. are supported.  
* More importantly, ERMaster allows you to model your database once and then export DDL scripts for various database systems—such as MySQL, Oracle, SQL Server, PostgreSQL, and more.

中文文档：<https://jeesite.com/docs/code-gen/#方式二-ermaster-建模>

# Install

Install the ERMaster plugin in [Eclipse](https://www.eclipse.org/downloads/) or [DBeaver Community](https://dbeaver.io/download/):

1. Go to **Help → Install New Software**.
2. In the **Work with** field, enter: `https://jeesite.com/ermaster` and press **Enter**.
3. Click **Select All**.
4. **Uncheck** the option *Group items by category*.
3. **Uncheck** the option *Contact all update sites during install to find required software*.
5. Click **Next** repeatedly until the **Finish** button appears, and complete the installation.

---

If you are using the latest version of **Spring Tool Suite (STS)**, you must first install the **GEF dependency library**:

1. Go to **Help → Install New Software**.
2. In the **Work with** field, enter: `http://download.eclipse.org/tools/gef/classic/releases/latest` and press **Enter**.
3. Click **Select All**.
3. **Uncheck** *Contact all update sites during install to find required software*.
4. Click **Next** repeatedly until the **Finish** button appears, and complete the installation.

After installing GEF, proceed with the same steps above to install the ERMaster plugin.

---

Alternatively, use the pre-integrated **Eclipse + ERMaster bundle**:  
Download directly from the attachments section of JeeSite V5.x: [https://gitee.com/thinkgem/jeesite5/attach_files](https://gitee.com/thinkgem/jeesite5/attach_files)

---

Alternatively, you can manually download the ERMaster source repository from:  

```
git clone https://gitee.com/thinkgem/jeesite5.git
```

After downloading it to your local disk, in the **Work with** field of the Install dialog, 
directly specify the local path to the `/ermasterr/updatesite` directory inside the downloaded repository to perform the installation.

If you are using an older version of Eclipse, you can also install other versions:

Copy the contents of the `/ermasterr/updatesite/plugins/org.insightech.er_x.y.z.jar` version 
to the dropins folder located in the root of your Eclipse installation.
Directory tree example:

```
Eclipse/
└── dropins/
    └── org.insightech.er_x.y.z.jar
```

# Release

1. Open file `/META-INF/MAINIFEST.MF` Mobify Version.
2. File -> Export -> Plug-in Development -> Deployable plug-ins and fragments -> Select org.insightech.er.
3. Open file `/features/feature.xml` Mobify Version and update upgrade info.
4. File -> Export -> Plug-in Development -> Deployable features.
5. Open `/updatesite/site.xml` -> Add Feature new version and right-click Remove old version and update upgrade info.

# License

Apache License V2.0

<https://jeesite.com>
