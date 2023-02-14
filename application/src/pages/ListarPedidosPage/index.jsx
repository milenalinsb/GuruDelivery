import React, { useEffect, useState } from 'react'
import { listAllPedidos } from '../../api/empresa'
import NavBar from '../../components/NavBar'
import PedidoCard from '../../components/PedidoCard'

export default function ListarPedidosPage() {

    const [pedidos, setPedidos] = useState([])

    async function loadPedidos(){
        const data = await listAllPedidos()
        setPedidos(data)
        console.dir(data)
    }

    useEffect(() => {
      loadPedidos()
    }, [])
    

  return (
    <>
        <NavBar/>
        <main>
            {pedidos.map(pedido => 
                <PedidoCard pedido={pedido}/>
            )}
        </main>
    
    </>
  )
}
