import client from "./client";

export async function getEmpresa(id){
    const resp = client.get("/empresas/"+id)
    return (await resp).data
}

export async function getProdutos(empresaId){
    const resp = client.get(`/empresas/${empresaId}/produtos`)
    return (await resp).data
}