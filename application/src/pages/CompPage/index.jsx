import React from 'react'
import InputText from '../../components/InputText'
import ProductCard from '../../components/ProductCard'
import Separator from '../../components/Separator'

export default function CompPage() {
  return (
    <div className='flex flex-1 flex-col p-5 bg-background items-center justify-center' >
      <div className='bg-surface max-w-6xl w-full'>
        <header className='bg-primary h-48 w-full rounded'>HEADER</header>
        <Separator/>
        <div className='px-20'>
          <InputText placeholder='Pesquisa' />
        </div>
        <main className='grid sm:grid-cols-3 md:grid-cols-4 bg-background justify-center gap-2 p-2'>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
          <ProductCard/>
        </main>
      </div>
    </div>
  )
}
