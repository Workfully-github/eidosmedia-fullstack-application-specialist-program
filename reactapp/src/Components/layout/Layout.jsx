import React from 'react'
import Footer from '../Footer/Footer'
import Navbar from '../Navbar/Navbar'

const Layout = ({children}) => {
  return (
    <>
    <div className="layout"></div>
    <Navbar />
    {children}
    <Footer />
    </>
  )
}

export default Layout