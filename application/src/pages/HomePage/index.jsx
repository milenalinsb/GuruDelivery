import React, { Fragment, useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import client from '../../api/client'
import { listAllEmpresas } from '../../api/empresa'
import HeaderCard from '../../components/HeaderCard'
import NavBar from '../../components/NavBar'
import SearchBar from '../../components/SearchBar'

export default function HomePage() {

    const [empresas, setEmpresas] = useState([])

    async function loadAll(){
        const data = await listAllEmpresas()
        setEmpresas(data)
    }

    useEffect(() => {
        loadAll()
    }, [])
    
  return (
    <>
        <NavBar/>
        <div className='flex flex-1 flex-col p-5 bg-background items-center justify-center' >
        <div className=' max-w-6xl w-full rounded-lg'>
            <header className='w-full flex text-on-primary'>
            
            </header>
            <div className='mt-2'>
            <SearchBar placeholder="Procure uma empresa" buttonText="Procurar"/>
            </div>
            <main className='grid grid-cols-1 sm:grid-cols-3 md:grid-cols-2 lg:grid-cols-2 bg-background justify-center gap-2 mt-2'>
                {empresas.map(empresa =>
                <Fragment key={empresa.email}>
                    <Link to={`/empresas/${empresa.id}`}>
                    <HeaderCard
                    email={empresa.email}
                    nome={empresa.nome}
                    telefone={empresa.telefone}
                    foto={empresa.fotoPerfil.includes("http")?empresa.fotoPerfil:`${client.defaults.baseURL}/uploads/${empresa.fotoPerfil}`}
                     />
                     </Link>
                </Fragment>
                )}
            </main>
        </div>
        </div>
    </>
  )
}
