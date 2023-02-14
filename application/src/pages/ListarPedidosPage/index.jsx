import React, { useEffect, useState } from 'react'
import { enviarPedido, listAllPedidos } from '../../api/empresa'
import LargeButton from '../../components/LargeButton'
import NavBar from '../../components/NavBar'
import PedidoCard from '../../components/PedidoCard'

export default function ListarPedidosPage() {

    const [pedidos, setPedidos] = useState([])

    async function loadPedidos(){
        const data = await listAllPedidos()
        setPedidos(data)
    }

    useEffect(() => {
      loadPedidos()
    }, [])
    
    async function onSubmit(id){
        const data = await enviarPedido(id)
        loadPedidos()
    }

  return (
    <>
        <NavBar/>
        <main>
            {pedidos.map(pedido =>
                <div className='flex flex-row items-center'>
                    <div className='basis-5/6'> 
                        <PedidoCard pedido={pedido}/>
                    </div>
                    <div className='basis-10'>
                        <LargeButton text={"Enviar"} action={() => onSubmit(pedido.id)} bg/>
                    </div>
                </div>
            )}
        </main>
    
    </>
  )
}
