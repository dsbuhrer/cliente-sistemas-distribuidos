package com.sd.client.app.packages.data.empresa;

import com.sd.client.app.base.PackageData;
import com.sd.client.app.models.Empresa;

import java.util.ArrayList;

public class GetEmpresaPackageData extends PackageData {
    private ArrayList<Empresa> empresas;

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public GetEmpresaPackageData() {
    }

    public GetEmpresaPackageData(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
}
