package ql.graph.cats

import co.dffrntlab.auth.core.api.UserResponseCreator
import co.dffrntlab.auth.core.api.signin.external.twitter.TwitterSignInService
import co.dffrntlab.auth.core.blacklist.DistributedBlacklistService
import co.dffrntlab.auth.core.error_handling.AuthExceptionMapper
import co.dffrntlab.auth.core.mailing.MailClient
import co.dffrntlab.auth.core.mailing.MailParamsProvider
import co.dffrntlab.auth.core.services.base.AnonymousUserService
import co.dffrntlab.auth.core.services.base.EmailAddressService
import co.dffrntlab.auth.core.services.base.SessionService
import co.dffrntlab.auth.core.services.base.UserService
import co.dffrntlab.auth.core.utils.DistributedMap
import co.dffrntlab.auth.core.utils.IdGenerator
import co.dffrntlab.auth.defaults.api.DefaultUserResponseCreator
import co.dffrntlab.auth.defaults.error_handling.DefaultAuthExceptionMapper
import co.dffrntlab.auth.defaults.mailing.EmptyMailParamsProvider
import co.dffrntlab.auth.defaults.mailing.LoggingMailClient
import co.dffrntlab.auth.defaults.services.base.InMemoryAnonymousUserService
import co.dffrntlab.auth.defaults.services.base.InMemoryEmailAddressService
import co.dffrntlab.auth.defaults.services.base.InMemorySessionService
import co.dffrntlab.auth.defaults.services.base.InMemoryUserService
import co.dffrntlab.auth.defaults.utils.InMemoryBlacklistDistributedMap
import co.dffrntlab.auth.defaults.utils.InMemoryTwitterRequestTokenDistributedMap
import co.dffrntlab.auth.defaults.utils.UUIDGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import twitter4j.auth.RequestToken
import java.time.Instant

@Configuration
open class CatsDffrntAuthConfiguration {
    @Bean
    open fun sessionService(): SessionService {
        return InMemorySessionService()
    }

    @Bean
    open fun userService(): UserService {
        return InMemoryUserService()
    }

    @Bean
    open fun emailAddressService(): EmailAddressService {
        return InMemoryEmailAddressService()
    }

    @Bean
    open fun anonymousUserService(): AnonymousUserService {
        return InMemoryAnonymousUserService()
    }

    @Bean(name = [DistributedBlacklistService.BLACKLIST_DISTRIBUTED_MAP])
    open fun blacklistDistributedMap(): DistributedMap<Any, Instant> {
        return InMemoryBlacklistDistributedMap()
    }

    @Bean(name = [TwitterSignInService.TWITTER_REQUEST_TOKEN_DISTRIBUTED_MAP])
    open fun twitterRequestTokenDistributedMap(): DistributedMap<String, RequestToken> {
        return InMemoryTwitterRequestTokenDistributedMap()
    }

    @Bean
    open fun authExceptionMapper(): AuthExceptionMapper {
        return DefaultAuthExceptionMapper()
    }

    @Bean
    open fun idGenerator(): IdGenerator<String> {
        return UUIDGenerator()
    }

    @Bean
    open fun mailParamsProvider(): MailParamsProvider {
        return EmptyMailParamsProvider()
    }

    @Bean
    open fun mailClient(): MailClient {
        return LoggingMailClient()
    }

    @Bean
    open fun userResponseCreator(): UserResponseCreator {
        return DefaultUserResponseCreator()
    }
}
