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

export async function getCarrinho(empresaId){
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const resp = await client.get(`/usuarios/${userId}/${empresaId}/carrinho`)
    return resp.data
}

export async function deleteFromCarrinho(empresaId, itemId){
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const resp = await client.delete(`/usuarios/${userId}/${empresaId}/carrinho/${itemId}`)
    return resp.data
}

export async function changeQuantityCarrinho(empresaId, itemId, quantidade){
    const user = localStorage.getItem("user")
    const userId = JSON.parse(user).id
    const data = {
        quantidade
    }
    const resp = await client.patch(`/usuarios/${userId}/${empresaId}/carrinho/${itemId}/alterar`, data)
    return resp.data
}

export async function postPedido(empresaId, enderecoId){
    const data = {
        enderecoId
    }
        const resp = await client.post(`/empresas/${empresaId}/pedidos`, data)
    return resp.data
}

