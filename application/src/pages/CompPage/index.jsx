import React from 'react'
import InputText from '../../components/InputText'
import NavBar from '../../components/NavBar'
import ProductCard from '../../components/ProductCard'
import SearchBar from '../../components/SearchBar'
import Separator from '../../components/Separator'

export default function CompPage() {
  return (
    <>
      <NavBar/>
    <div className='flex flex-1 flex-col p-5 bg-background items-center justify-center' >
      <div className='bg-surface max-w-6xl w-full rounded-lg'>
        <header className='bg-primary h-48 w-full flex text-on-primary'>
          <img src='#'/>
          <div className='p-2'>
            <div className='text-2xl'>Nome</div>
            <div>info</div>
          </div>
        </header>
        <div className='mt-2'>
          <SearchBar placeholder="Procure um produto" buttonText="Procurar"/>
        </div>
        <main className='grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 bg-background justify-center gap-2 mt-2'>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
        </main>
      </div>
    </div>
    </>
  )
}
