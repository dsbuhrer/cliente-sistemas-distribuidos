package com.sd.client.app.packages.data.empresa;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Empresa;

public class FindEmpresaPackageData extends PackageData {
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public FindEmpresaPackageData() {
    }

    public FindEmpresaPackageData(Empresa empresa) {
        this.empresa = empresa;
    }
}
