import client from "./client";

export async function getEmpresa(id){
    const resp = client.get("/empresas/"+id)
    return (await resp).data
}

export async function getProdutos(empresaId){
    const resp = client.get(`/empresas/${empresaId}/produtos`)
    return (await resp).data
}

export async function addProdutoCarrinho(produtoId, quantidade){
    const data= {
        produto: produtoId,
        quantidade: quantidade
    }
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const resp = await client.post(`/usuarios/${userId}/carrinho/adicionar`, data)
    return resp.data
}